<script lang="ts" context="module">
    import type { PasswordModel } from "$lib/types";

    export default interface PasswordDeleteEvent {
        password: PasswordModel;
    }
</script>

<script lang="ts">
    import { Icon } from "svelte-awesome";
    import { check, clipboard, eye, eyeSlash, trash } from "svelte-awesome/icons";
    import { createEventDispatcher } from "svelte";

    const dispatcher = createEventDispatcher();

    export let password: PasswordModel;
    let showPassword = false;
    let copied = false;

    const toggleVisibility = async () => {
        console.log("toggle");
        showPassword = !showPassword;
    };

    const onCopy = async () => {
        await navigator.clipboard.writeText(password.password);
        copied = true;
    };

    const onDelete = async () => {
        dispatcher("passwordDelete", {
            password: password,
        });
    }
</script>

<div class="my-2 flex">
    <div
      on:click={toggleVisibility}
      class="border rounded-l p-4 border-gray-500 hover:text-amber-700 cursor-pointer"
    >
        <button>
            {#if showPassword}
                <Icon data={eyeSlash} class="pb-1" scale={1.3} />
            {:else}
                <Icon data={eye} class="pb-1" scale={1.3} />
            {/if}
        </button>
    </div>
    <div
      on:click={onDelete}
      class="border p-4 border-gray-500 hover:text-red-600 cursor-pointer"
    >
        <button>
            <Icon data={trash} class="pb-1" scale={1.3} />
        </button>
    </div>
    <div
      on:click={onCopy}
      class="border p-4 border-gray-500 hover:text-amber-700 cursor-pointer"
    >
        <button>
            {#if copied}
                <Icon data={check} class="pb-1 text-green-600" scale={1.3} />
            {:else }
                <Icon data={clipboard} class="pb-1" scale={1.3} />
            {/if}
        </button>
    </div>
    <div class="border p-4 border-gray-500">
        <span>{password.generatedAt.toISOString()}</span>
    </div>
    <div class="border rounded-r p-4 border-gray-500 flex-auto">
        {#if showPassword}
            <span on:dblclick={onCopy}>{password.password}</span>
        {:else}
            <span>{"*".repeat(password.password.length)}</span>
        {/if}
    </div>
</div>
