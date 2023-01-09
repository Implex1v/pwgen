<script lang="ts" context="module">
    export default interface PasswordEvent {
        password: string;
    }
</script>

<script lang="ts">
    import { Icon } from "svelte-awesome";
    import { copy, key } from "svelte-awesome/icons";
    import { getPassword } from "../lib/client";
    import { createEventDispatcher } from "svelte";

    const dispatch = createEventDispatcher();
    let password = "";
    let copied = false;

    const onGenerate = async () => {
        const data = await getPassword();
        password = data.password;
        copied = false;

        dispatch("password", {
            password: password,
        });
    };

    const onCopy = async() => {
        await navigator.clipboard.writeText(password);
        copied = true;
    };
</script>

<div class="flex space-x-5">
    <button on:click={onGenerate} class="rounded-lg text-lg bg-blue-700 hover:bg-blue-800 px-4 py-1">
        <Icon data={key} />
        Generate
    </button>
    <div class="flex space-x-0">
        <input
          type="text"
          bind:value={password}
          readonly
          class="border-y border-l border-gray-500 rounded-x rounded-l text-lg py-1 bg-gray-900 px-2"
          size="50"
        />
        <button
          on:click={onCopy}
          class="border border-gray-500 rounded-r text-lg py-1 px-4 hover:text-green-600 {copied ? 'text-green-600' : ''}"
          class:copied
        >
            <Icon data={copy} />
            {#if copied}
                copied!
            {:else}
                copy&nbsp;&nbsp;
            {/if}
        </button>
    </div>
</div>
